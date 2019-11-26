# Demo Project for Databinding issue

https://github.com/grails/grails-core/issues/11423

Custom date format is configured in `grails-app/conf/application.groovy`

```
grails.databinding.dateFormats = ['MMddyyyy']
```

`WidgetController.save()` attempts to bind a JSON payload similar to this:

```
{
  "productionDate": "04022019"
}
```

To a Widget class (POGO)

```
package databindingformatexample

class Widget {

    Date productionDate
}
```

The test at `src/integration-test/databindingformatexample/WidgetControllerIntegrationSpec` demonstrates the issue. Note that the call to `bindData()` does not succesfully bind the custom date string to the `productionDate` property.

## Workaround

Adding (or uncommenting) the `micronaut-runtime-groovy` dependency in `build.gradle` appears to resolve the issue; the `productionDate` property is bound correctly and the integration test passes.

## Issue with `ControllerUnitTest` Trait

The test at `src/test/databindingformatexample/WidgetControllerSpec` theoretically should demonstrate the issue, however in reality it does not. The databinding apparently works with or without the `micronaut-runtime-groovy` dependency when using the trait. This is not desirable behavior as the running application does not behave the same way as does the unit test, when using this trait.