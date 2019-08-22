package veemos.server.grails

import grails.gorm.services.Service

@Service(ModelRange)
interface ModelRangeService {

    ModelRange get(Serializable id)

    List<ModelRange> list(Map args)

    Long count()

    void delete(Serializable id)

    ModelRange save(ModelRange modelRange)

}