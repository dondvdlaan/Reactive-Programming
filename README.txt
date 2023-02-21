Building Block for Reactive Programming

Herewith a very simple example of reactive programming, which is an improved way of communicating between your app and
libraries or infrastructure components. Traditional REST API design makes use of thread pools for concurrent requests,
synchronous and blocking communication. While for most applications this dseign meets the requirements, for more
demanding circumstances Reactive programming might be an alternative.

Reactive programming is an asychroneous none blocking stream communication with the possibility of regulating the
stream by way of back pressure.

In this example we make use of Spring WebFlux.

Summary
- Java 17
- Spring WebFlux
- MySQL with R2DBC driver
- Endpoint at localhost:5000/all
- Testing for Controller and Repository

