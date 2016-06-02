package com.github.ckozak.json

import com.github.ckozak.json.models._

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
