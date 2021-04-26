package rules;

public class RestAssuredAllureFilter {//extends AllureRestAssured {

    /*
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext filterContext) {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        StepResult stepResult = (new StepResult()).setStatus(Status.PASSED)
                .setName(String.format("Запрос %s по ссылке: %s", requestSpec.getMethod(), requestSpec.getURI()));
        List<Parameter> params = new ArrayList<>();
        requestSpec.getRequestParams()
                .forEach((key, value) ->
                                 params.add(new Parameter().setName(key)
                                                    .setValue(value)));
        requestSpec.getFormParams()
                .forEach((key, value) ->
                                 params.add(new Parameter().setName(key)
                                                    .setValue(value)));
        stepResult.setParameters(params);
        lifecycle.startStep(UUID.randomUUID()
                                    .toString(), stepResult);

        Response response;
        try {
            response = super.filter(requestSpec, responseSpec, filterContext);
        } finally {
            lifecycle.stopStep();
        }
        return response;
    }

     */
}
