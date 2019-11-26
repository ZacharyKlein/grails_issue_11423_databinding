package databindingformatexample

import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import spock.lang.Shared
import spock.lang.Specification

@Integration
class WidgetControllerIntegrationSpec extends Specification {
    @Shared HttpClient client

    @OnceBefore
    void init() {
        String baseUrl = "http://localhost:$serverPort"
        this.client  = HttpClient.create(baseUrl.toURL())
    }

    def 'test custom date format binding'() {
        when:
        HttpRequest request = HttpRequest.POST('/widget/save', [productionDate: "04022019"])
        HttpResponse<List<Map>> resp = client.toBlocking().exchange(request, String)

        then:
        resp.status == HttpStatus.OK
        resp.body.get().contains("Tue Apr 02")
    }


}
