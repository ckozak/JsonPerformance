package com.github.ckozak.json

import com.github.ckozak.json.models._
import spray.json.DefaultJsonProtocol

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
