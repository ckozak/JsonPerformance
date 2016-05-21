package com.github.ckozak

import java.util.UUID

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.github.ckozak.models._
import org.json4s.DefaultFormats
import spray.json.DefaultJsonProtocol

import scala.util.Random

case class Example(
  id: String,
  string: String,
  double: Double,
  date: Long,
  date2: Long
)

object SprayJsonUtils {
  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val exampleFormat = jsonFormat5(Example)
    implicit val kFormat = jsonFormat2(AppDefaultSettings)
    implicit val aFormat = jsonFormat5(AppAdminExtras)
    implicit val mFormat = jsonFormat1(SocialMetaData)
    implicit val bFormat = jsonFormat3(AppStore)
    implicit val cFormat = jsonFormat7(MoreAppsSettings)
    implicit val dFormat = jsonFormat2(TestingExtras)
    implicit val eFormat = jsonFormat2(RawExtras)
    implicit val n1Format = jsonFormat2(ConfirmationUXSetting)
    implicit val n2Format = jsonFormat2(VideoControlsBackgroundUXSetting)
    implicit val n3Format = jsonFormat3(PostVideoRewardToasterUXSetting)
    implicit val n4Format = jsonFormat4(CancelPopupUXSetting)
    implicit val nFormat = jsonFormat7(VideoUX)
    implicit val fFormat = jsonFormat11(VideoSettings)
    implicit val appsFormat = jsonFormat20(Apps)
    implicit val deviceFormat = jsonFormat3(Device)
  }
}

object LiftwebUtils {
  import net.liftweb.json._

  implicit val formats = Serialization.formats(NoTypeHints)
}

object UPickleUtils {
  import upickle.default._
}

object JacksonUtils {
  val objectMapper = {
    val objectMapper = new ObjectMapper with ScalaObjectMapper
    objectMapper.registerModule(DefaultScalaModule)
    objectMapper
  }
}

object Json4sUtils {
  implicit val formats = DefaultFormats
}

object PlayUtils {
  import play.api.libs.json._
  implicit val modelFormat = Json.format[Example]
  implicit val kFormat = Json.format[AppDefaultSettings]
  implicit val aFormat = Json.format[AppAdminExtras]
  implicit val mFormat = Json.format[SocialMetaData]
  implicit val bFormat = Json.format[AppStore]
  implicit val cFormat = Json.format[MoreAppsSettings]
  implicit val dFormat = Json.format[TestingExtras]
  implicit val eFormat = Json.format[RawExtras]
  implicit val n1Format = Json.format[ConfirmationUXSetting]
  implicit val n2Format = Json.format[VideoControlsBackgroundUXSetting]
  implicit val n3Format = Json.format[PostVideoRewardToasterUXSetting]
  implicit val n4Format = Json.format[CancelPopupUXSetting]
  implicit val nFormat = Json.format[VideoUX]
  implicit val fFormat = Json.format[VideoSettings]
  implicit val appsFormat = Json.format[Apps]
  implicit val deviceFormat = Json.format[Device]
}

object ArgonautUtils {
  import argonaut._, Argonaut._, Shapeless._

  implicit val encode = EncodeJson.of[Example]
  implicit val decode = DecodeJson.of[Example]



  implicit val encode3 = EncodeJson.of[AppDefaultSettings]
  implicit val decode3 = DecodeJson.of[AppDefaultSettings]

  implicit val encode4 = EncodeJson.of[AppAdminExtras]
  implicit val decode4 = DecodeJson.of[AppAdminExtras]

  implicit val encode5 = EncodeJson.of[SocialMetaData]
  implicit val decode5 = DecodeJson.of[SocialMetaData]

  implicit val encode6 = EncodeJson.of[AppStore]
  implicit val decode6 = DecodeJson.of[AppStore]

  implicit val encode7 = EncodeJson.of[MoreAppsSettings]
  implicit val decode7 = DecodeJson.of[MoreAppsSettings]

  implicit val encode8 = EncodeJson.of[TestingExtras]
  implicit val decode8 = DecodeJson.of[TestingExtras]

  implicit val encode9 = EncodeJson.of[RawExtras]
  implicit val decode9 = DecodeJson.of[RawExtras]

  implicit val encode10 = EncodeJson.of[ConfirmationUXSetting]
  implicit val decode10 = DecodeJson.of[ConfirmationUXSetting]

  implicit val encode11 = EncodeJson.of[VideoControlsBackgroundUXSetting]
  implicit val decode11 = DecodeJson.of[VideoControlsBackgroundUXSetting]

  implicit val encode12 = EncodeJson.of[PostVideoRewardToasterUXSetting]
  implicit val decode12 = DecodeJson.of[PostVideoRewardToasterUXSetting]

  implicit val encode13 = EncodeJson.of[CancelPopupUXSetting]
  implicit val decode13 = DecodeJson.of[CancelPopupUXSetting]

  implicit val encode14 = EncodeJson.of[VideoUX]
  implicit val decode14 = DecodeJson.of[VideoUX]

  implicit val encode15 = EncodeJson.of[VideoSettings]
  implicit val decode15 = DecodeJson.of[VideoSettings]

  implicit val encode2 = EncodeJson.of[Apps]
  implicit val decode2 = DecodeJson.of[Apps]

  implicit val encodeDevice = EncodeJson.of[Device]
  implicit val decodeDevice = DecodeJson.of[Device]
}