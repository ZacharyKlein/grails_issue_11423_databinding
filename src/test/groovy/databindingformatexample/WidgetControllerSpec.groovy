package databindingformatexample

import grails.testing.web.controllers.ControllerUnitTest
import org.junit.Ignore
import org.springframework.http.HttpHeaders
import spock.lang.Specification

class WidgetControllerSpec extends Specification implements ControllerUnitTest<WidgetController> {

    @Ignore //TODO: Test does not fail when it should
    void "when custom date format is used"() {
        when:
        request.JSON = """{
            "productionDate": "04022019"
            }"""
        controller.save()

        then:"expected date is returned"
        response.status == 200
        response.text.contains "Tue Apr 02"
    }

    boolean disableControllerProxy() {
        true
    }
}
