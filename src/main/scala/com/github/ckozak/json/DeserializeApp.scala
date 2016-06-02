package com.github.ckozak.json

import argonaut.Argonaut._
import com.github.ckozak.json.models.Apps
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}
import upickle.default._

@State(Scope.Benchmark)
class AppsHolder {
  val item = """{
                 "id": "ჟ",
                 "company": "ꭋ櫭呗ࡖ㟇",
                 "name":"name",
                 "signature": "ძ긞⌍狂៨",
                 "nonTrackable": true,
                 "blockS2S": false,
                 "adminExtras": {
                   "adminAdvertiserDisabled": true,
                   "adminPublisherDisabled": true,
                   "adminCpiDisabled": true,
                   "appDefaultSettings": {
                   	"maxAdsDaily": 1,
                   	"maxAdsHourly": 2
               	    },
                   "buyoutNeverShowOverride": false
                 },
                 "url": "㤑",
                 "nonGame": true,
                 "appstore": {
                   "categories": [
                     "咋꺊"
                   ],
                   "contentRating": [
                     "漩着",
                     "ퟅ뤝"
                   ],
                   "socialMetaData": {
                     "starRating": 9.7
                   }
                 },
                 "moreAppsSettings": {
                   "caching": true,
                   "showAdvertising": false,
                   "headerBackgroundColor": "sdfsdf",
                   "headerTextColor": "sfasdf",
                   "headerText": "Sdfa",
                   "moreAppsCustomAssets": ["jksdjhf", "si"],
                   "appDescription": "ksdjfhlkjsj"
                 },
                 "testingExtras": {
                   "testing": true,
                   "testModeEnd": 8
                 },
                 "hasCompletedViewCallback": false,
                 "hasInstallCallback": false,
                 "itunesId": "kjsdfn",
                 "rawExtras": {
                   "moreButtonText": "Ͱ",
                   "moreFeaturedText": "sadf"
                 },
                 "deepLink": "휷",
                 "videoSettings": {
                   "prerollPopup": false,
                   "animation": 3,
                   "reward": 8,
                   "videoIcon": "jksdlfja;s",
                   "replayUrl": "sajkhdf",
                   "ux": {
                     "confirmation": {
                     		"color": "red",
                     		"text":"sadf"
                     	},
                     "videoControlsTogglable": true,
                     "postVideoIconEnabled": true,
                     "videoControlsBackground": {
                       "color": "saf",
                       "borderColor": "qrqwe"
                     },
                     "videoProgressTimerEnabled": false,
                     "postVideoRewardToaster": {
                     	"text": "2etwe",
                     	"enabled": true,
                     	"position": "left"
                     	},
                     "cancelPopup": {
                     	"cancel": "sdjlf",
                     	"text": "sdjfk",
                     	"confirm": "aisdojf",
                     	"title": "sdfljak"
                     }
                   },
                   "videoClickButtonEnabled": true,
                   "videoClickButton": "asdfhkjlk",
                   "postVideoButton": "jaskdhf",
                   "fullscreen": true,
                   "videoConfirmationButton": "sdkfl"
                 },
                 "activated": false,
                 "selectedForApps": [
                   "癳"
                 ]
               }"""
}

class DeserializeApp {

  @Benchmark
  def jackson(state: AppsHolder): Unit = {
    import JacksonUtils._
    objectMapper.readValue[Apps](state.item)
  }

  @Benchmark
  def json4sJackson(state: AppsHolder): Unit = {
    import Json4sUtils._
    org.json4s.jackson.Serialization.read[Apps](state.item)
  }

  @Benchmark
  def circeJackson(state: AppsHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jackson._
    decode[Apps](state.item)
  }

  @Benchmark
  def circeJawn(state: AppsHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jawn._
    decode[Apps](state.item)
  }

  @Benchmark
  def sprayJson(state: AppsHolder): Unit = {
    import spray.json._
    import SprayJsonUtils.MyJsonProtocol._
    state.item.parseJson.convertTo[Apps]
  }

  /*@Benchmark
  def argonaut(state: AppsHolder): Unit = {
    import ArgonautUtils._
    state.item.decodeOption[Apps]
  }*/

  @Benchmark
  def playJson(state: AppsHolder): Unit = {
    import play.api.libs.json._
    import PlayUtils._
    Json.fromJson[Apps](Json.parse(state.item))
  }

  @Benchmark
  def liftweb(state: AppsHolder): Unit = {
    import LiftwebUtils._
    import net.liftweb.json.Serialization.read
    read[Apps](state.item)
  }

  @Benchmark
  def upickle(state: AppsHolder): Unit = {
    read[Apps](state.item)
  }
}
