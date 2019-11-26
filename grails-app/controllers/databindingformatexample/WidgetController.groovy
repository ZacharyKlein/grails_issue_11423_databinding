package databindingformatexample

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED

class WidgetController {

    def save() {
        Widget widget = new Widget()
        bindData(widget, request.JSON)

        println "JSON: ${request.JSON}"
        println "widget: ${widget.productionDate}"

        render(text: widget.productionDate)
    }

    def create() {}
}
