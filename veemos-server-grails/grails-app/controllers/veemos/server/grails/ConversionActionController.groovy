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
class ConversionActionController {

    ConversionActionService conversionActionService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond conversionActionService.list(params), model:[conversionActionCount: conversionActionService.count()]
    }

    def show(Long id) {
        respond conversionActionService.get(id)
    }

    @Transactional
    def save(ConversionAction conversionAction) {
        if (conversionAction == null) {
            render status: NOT_FOUND
            return
        }
        if (conversionAction.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond conversionAction.errors
            return
        }

        try {
            conversionActionService.save(conversionAction)
        } catch (ValidationException e) {
            respond conversionAction.errors
            return
        }

        respond conversionAction, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(ConversionAction conversionAction) {
        if (conversionAction == null) {
            render status: NOT_FOUND
            return
        }
        if (conversionAction.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond conversionAction.errors
            return
        }

        try {
            conversionActionService.save(conversionAction)
        } catch (ValidationException e) {
            respond conversionAction.errors
            return
        }

        respond conversionAction, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        conversionActionService.delete(id)

        render status: NO_CONTENT
    }
}
