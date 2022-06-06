package test.scala.test

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt

class HeavySimulation extends Simulation {

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
      atOnceUsers(100),
      constantUsersPerSec(100).during(1.minutes),
      rampUsersPerSec(100).to(200).during(1.minutes),
      constantUsersPerSec(300).during(1.minutes),
      rampUsersPerSec(300).to(500).during(1.minutes),
      constantUsersPerSec(1000).during(1.minutes),
      rampUsersPerSec(1000).to(2000).during(1.minutes),
      heavisideUsers(2000).during(1.minutes)
    ).protocols(httpProtocol)
  )
}