package Package1

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TestScript1 extends Simulation {

  val httpProtocol = http
    .baseUrl("http://computer-database.gatling.io")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.34 Safari/537.36")

  val headers_0 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept-Language" -> "en-US,en;q=0.9",
    "Upgrade-Insecure-Requests" -> "1")



  val scn = scenario("Baseline1")
    .exec(http("request_12")
      .get("/computers")
      .headers(headers_0)
      .resources(http("request_1")
        .get("/assets/stylesheets/bootstrap.min.css"),
        http("request_2")
          .get("/assets/stylesheets/main.css")))
    .pause(10)
    .exec(http("request_3")
      .get("/computers?f=ACE")
      .headers(headers_0))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
