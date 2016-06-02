package com.github.ckozak.json.models

case class AppAdminExtras(
  adminAdvertiserDisabled: Option[Boolean],
  adminPublisherDisabled: Option[Boolean],
  adminCpiDisabled: Option[Boolean],
  appDefaultSettings: Option[AppDefaultSettings],
  buyoutNeverShowOverride: Option[Boolean]
)

case class AppDefaultSettings(
  maxAdsDaily: Option[Int],
  maxAdsHourly: Option[Int]
)

case class AppStore(
  categories: Set[String],
  contentRating: Set[String],
  socialMetaData: SocialMetaData
)

case class SocialMetaData(
  starRating: Option[Double]
)

case class MoreAppsSettings(
  caching: Option[Boolean],
  showAdvertising: Option[Boolean],
  headerBackgroundColor: Option[String],
  headerTextColor: Option[String],
  headerText: Option[String],
  moreAppsCustomAssets: Option[Seq[String]],
  appDescription: Option[String]
)

case class TestingExtras(
  testing: Boolean,
  testModeEnd: Option[Int]
)

case class RawExtras(
  moreButtonText: Option[String],
  moreFeaturedText: Option[String]
)

case class VideoSettings(
  prerollPopup: Boolean,
  animation: Option[Int],
  reward: Option[Int],
  videoIcon: Option[String],
  replayUrl: Option[String],
  ux: VideoUX,
  videoClickButtonEnabled: Boolean,
  videoClickButton: String,
  postVideoButton: Option[String],
  fullscreen: Boolean,
  videoConfirmationButton: String
)

case class ConfirmationUXSetting(
  color: String,
  text: String
)

case class VideoControlsBackgroundUXSetting(
  color: String,
  borderColor: String
)

case class PostVideoRewardToasterUXSetting(
  text: String,
  enabled: Option[Boolean],
  position: String
)

case class CancelPopupUXSetting(
  cancel: String,
  text: String,
  confirm: String,
  title: String
)

case class VideoUX(
  confirmation: Option[ConfirmationUXSetting],
  videoControlsTogglable: Boolean,
  postVideoIconEnabled: Option[Boolean],
  videoControlsBackground: VideoControlsBackgroundUXSetting,
  videoProgressTimerEnabled: Boolean,
  postVideoRewardToaster: Option[PostVideoRewardToasterUXSetting],
  cancelPopup: Option[CancelPopupUXSetting]
)

case class Apps(
  id: String,
  company: String,
  name: Option[String],
  signature: String,
  nonTrackable: Boolean,
  blockS2S: Boolean,
  adminExtras: AppAdminExtras,
  url: Option[String],
  nonGame: Option[Boolean],
  appstore: AppStore,
  moreAppsSettings: Option[MoreAppsSettings],
  testingExtras: TestingExtras,
  hasCompletedViewCallback: Boolean,
  hasInstallCallback: Boolean,
  itunesId: Option[String],
  rawExtras: RawExtras,
  deepLink: Option[String],
  videoSettings: VideoSettings,
  activated: Boolean,
  selectedForApps: Option[Set[String]]
)

