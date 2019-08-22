package veemos.server.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class DivisionController {

    DivisionService divisionService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond divisionService.list(params), model:[divisionCount: divisionService.count()]
    }

    def show(Long id) {
        respond divisionService.get(id)
    }

    @Transactional
    def save(Division division) {
        if (division == null) {
            render status: NOT_FOUND
            return
        }
        if (division.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond division.errors
            return
        }

        try {
            divisionService.save(division)
        } catch (ValidationException e) {
            respond division.errors
            return
        }

        respond division, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Division division) {
        if (division == null) {
            render status: NOT_FOUND
            return
        }
        if (division.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond division.errors
            return
        }

        try {
            divisionService.save(division)
        } catch (ValidationException e) {
            respond division.errors
            return
        }

        respond division, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        divisionService.delete(id)

        render status: NO_CONTENT
    }
}
