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
class ModelRangeController {

    ModelRangeService modelRangeService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond modelRangeService.list(params), model:[modelRangeCount: modelRangeService.count()]
    }

    def show(Long id) {
        respond modelRangeService.get(id)
    }

    @Transactional
    def save(ModelRange modelRange) {
        if (modelRange == null) {
            render status: NOT_FOUND
            return
        }
        if (modelRange.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond modelRange.errors
            return
        }

        try {
            modelRangeService.save(modelRange)
        } catch (ValidationException e) {
            respond modelRange.errors
            return
        }

        respond modelRange, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(ModelRange modelRange) {
        if (modelRange == null) {
            render status: NOT_FOUND
            return
        }
        if (modelRange.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond modelRange.errors
            return
        }

        try {
            modelRangeService.save(modelRange)
        } catch (ValidationException e) {
            respond modelRange.errors
            return
        }

        respond modelRange, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        modelRangeService.delete(id)

        render status: NO_CONTENT
    }
}
