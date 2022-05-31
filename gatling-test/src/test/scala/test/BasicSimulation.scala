package test.scala.test

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt

class BasicSimulation extends Simulation {

  val csvFeeder: BatchableFeederBuilder[String]#F = csv("artist.csv").circular
  val httpProtocol: HttpProtocolBuilder = http.baseUrl("http://localhost:8080/search/")

  val scn: ScenarioBuilder =
    scenario("SearchArtist")
      .feed(csvFeeder)
      .exec(
        http("searchArtist")
          .get("/${artistLetter}")
      )
      .pause(7)

  setUp(
    scn.inject(
      nothingFor(1),
      atOnceUsers(10),
      rampUsers(10).during(1),
      constantUsersPerSec(20).during(5),
      constantUsersPerSec(20).during(5).randomized,
      rampUsersPerSec(10).to(20).during(3.minutes),
      rampUsersPerSec(10).to(20).during(3.minutes).randomized
    ).protocols(httpProtocol)
  )
}
