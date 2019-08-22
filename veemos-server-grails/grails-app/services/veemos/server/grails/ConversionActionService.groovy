package veemos.server.grails

import grails.gorm.services.Service

@Service(ConversionAction)
interface ConversionActionService {

    ConversionAction get(Serializable id)

    List<ConversionAction> list(Map args)

    Long count()

    void delete(Serializable id)

    ConversionAction save(ConversionAction conversionAction)

}