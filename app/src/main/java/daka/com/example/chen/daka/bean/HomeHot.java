package daka.com.example.chen.daka.bean;

import com.longevitysoft.android.xml.plist.domain.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2016/3/10.
 */
public class HomeHot {
    @Override
    public String toString() {
        return "HomeHot{" +
                "Status=" + Status +
                ", Data=" + Data +
                ", Msg='" + Msg + '\'' +
                '}';
    }



    public int Status;


    public DataEntity Data;
    public String Msg;

    public static class DataEntity {
        public int FilterType;
        public String LocName;
        public String OrderStr;

        public ArrayList<HomeViewListEntity> HomeViewList;


        @Override
        public String toString() {
            return "DataEntity{" +
                    "FilterType=" + FilterType +
                    ", LocName='" + LocName + '\'' +
                    ", OrderStr='" + OrderStr + '\'' +
                    ", HomeViewList=" + HomeViewList +
                    '}';
        }

        public static class HomeViewListEntity {
            public int Type;


            public PartnerPlanEntity PartnerPlan;

            public BannerEntity Banner;


            @Override
            public String toString() {
                return "HomeViewListEntity{" +
                        "Type=" + Type +
                        ", PartnerPlan=" + PartnerPlan +
                        ", Banner=" + Banner +
                        '}';
            }

            public static class BannerEntity {
                public int CategoryId;
                public String Title;
                public String CoverUrl;
                public String CoverThumbUrl;
                public String WebsiteCoverUrl;
                public String WebsiteCoverThumbUrl;
                public int Type;
                public String Content;
                public String DescInfo;
                public int Weight;

                @Override
                public String toString() {
                    return "BannerEntity{" +
                            "CategoryId=" + CategoryId +
                            ", Title='" + Title + '\'' +
                            ", CoverUrl='" + CoverUrl + '\'' +
                            ", CoverThumbUrl='" + CoverThumbUrl + '\'' +
                            ", WebsiteCoverUrl='" + WebsiteCoverUrl + '\'' +
                            ", WebsiteCoverThumbUrl='" + WebsiteCoverThumbUrl + '\'' +
                            ", Type=" + Type +
                            ", Content='" + Content + '\'' +
                            ", DescInfo='" + DescInfo + '\'' +
                            ", Weight=" + Weight +
                            '}';
                }
            }

            public static class PartnerPlanEntity {
                public String PlanGuid;
                public String DepartName;
                public String StartTime;
                public String EndTime;
                public int DaysLong;
                public int ScaleMax;
                public int ScaleMin;
                public String Description;
                public String ParticipateNote;
                public String FirstPhotoUrl;
                public String FirstPhotoThumbUrl;
                public String SecondPhotoUrl;
                public String SecondPhotoThumbUrl;
                public String ThirdPhotoUrl;
                public String ThirdPhotoThumbUrl;
                public int FavorNum;
                public int ForwardNum;
                public int UnreadCommentNum;
                public int IsFavored;
                public int IsMember;
                public int IsCheckedIn;
                public int IsEvalued;
                public int IsArrived;
                public int IsProvideTourGuide;
                public int IsProvideCar;
                public int IsNeedReview;
                public int IsNeedIdentity;
                public String PublishPlace;
                public int UserRouteId;
                public String RoomId;
                public String RoomTitle;
                public String RoomAvatar;
                public int IsAllowPhoneContact;
                public String PlanShareTitle;
                public String PlanShareUrl;
                public int UserNum;
                public int BrowseNumber;
                public int CommentNumber;
                public int Relation;
                public int IsAlert;
                public int Weight;
                public String CreatedTime;
                public String UpdatedTime;
                public String CostInclude;
                public String CostExclude;
                public int CostPrice;
                public int CostEarnest;
                public int TotalOrderNumber;
                public int TotalEarnest;
                public int TotalOrderStatus;
                public String StageMaster;
                public int TotalStageOrderNumber;
                public String Declaration;
                public String GatherTime;
                public String GatherPlace;
                public int AvgPoint;
                public List<String> DestinationNames;


                public List<TourThemesEntity> TourThemes;
                public List<?> CarIdentity;


                public ArrayList<MemberListEntity> MemberList;
                public List<?> ApplyingList;
                public List<?> CommentList;
                public List<?> UserRoute;


                public List<StageEntity> Stage;

                @Override
                public String toString() {
                    return "PartnerPlanEntity{" +
                            "PlanGuid='" + PlanGuid + '\'' +
                            ", DepartName='" + DepartName + '\'' +
                            ", StartTime='" + StartTime + '\'' +
                            ", EndTime='" + EndTime + '\'' +
                            ", DaysLong=" + DaysLong +
                            ", ScaleMax=" + ScaleMax +
                            ", ScaleMin=" + ScaleMin +
                            ", Description='" + Description + '\'' +
                            ", ParticipateNote='" + ParticipateNote + '\'' +
                            ", FirstPhotoUrl='" + FirstPhotoUrl + '\'' +
                            ", FirstPhotoThumbUrl='" + FirstPhotoThumbUrl + '\'' +
                            ", SecondPhotoUrl='" + SecondPhotoUrl + '\'' +
                            ", SecondPhotoThumbUrl='" + SecondPhotoThumbUrl + '\'' +
                            ", ThirdPhotoUrl='" + ThirdPhotoUrl + '\'' +
                            ", ThirdPhotoThumbUrl='" + ThirdPhotoThumbUrl + '\'' +
                            ", FavorNum=" + FavorNum +
                            ", ForwardNum=" + ForwardNum +
                            ", UnreadCommentNum=" + UnreadCommentNum +
                            ", IsFavored=" + IsFavored +
                            ", IsMember=" + IsMember +
                            ", IsCheckedIn=" + IsCheckedIn +
                            ", IsEvalued=" + IsEvalued +
                            ", IsArrived=" + IsArrived +
                            ", IsProvideTourGuide=" + IsProvideTourGuide +
                            ", IsProvideCar=" + IsProvideCar +
                            ", IsNeedReview=" + IsNeedReview +
                            ", IsNeedIdentity=" + IsNeedIdentity +
                            ", PublishPlace='" + PublishPlace + '\'' +
                            ", UserRouteId=" + UserRouteId +
                            ", RoomId='" + RoomId + '\'' +
                            ", RoomTitle='" + RoomTitle + '\'' +
                            ", RoomAvatar='" + RoomAvatar + '\'' +
                            ", IsAllowPhoneContact=" + IsAllowPhoneContact +
                            ", PlanShareTitle='" + PlanShareTitle + '\'' +
                            ", PlanShareUrl='" + PlanShareUrl + '\'' +
                            ", UserNum=" + UserNum +
                            ", BrowseNumber=" + BrowseNumber +
                            ", CommentNumber=" + CommentNumber +
                            ", Relation=" + Relation +
                            ", IsAlert=" + IsAlert +
                            ", Weight=" + Weight +
                            ", CreatedTime='" + CreatedTime + '\'' +
                            ", UpdatedTime='" + UpdatedTime + '\'' +
                            ", CostInclude='" + CostInclude + '\'' +
                            ", CostExclude='" + CostExclude + '\'' +
                            ", CostPrice=" + CostPrice +
                            ", CostEarnest=" + CostEarnest +
                            ", TotalOrderNumber=" + TotalOrderNumber +
                            ", TotalEarnest=" + TotalEarnest +
                            ", TotalOrderStatus=" + TotalOrderStatus +
                            ", StageMaster='" + StageMaster + '\'' +
                            ", TotalStageOrderNumber=" + TotalStageOrderNumber +
                            ", Declaration='" + Declaration + '\'' +
                            ", GatherTime='" + GatherTime + '\'' +
                            ", GatherPlace='" + GatherPlace + '\'' +
                            ", AvgPoint=" + AvgPoint +
                            ", DestinationNames=" + DestinationNames +
                            ", TourThemes=" + TourThemes +
                            ", CarIdentity=" + CarIdentity +
                            ", MemberList=" + MemberList +
                            ", ApplyingList=" + ApplyingList +
                            ", CommentList=" + CommentList +
                            ", UserRoute=" + UserRoute +
                            ", Stage=" + Stage +
                            '}';
                }

                public static class TourThemesEntity {
                    public int TourThemeId;
                    public String Title;
                    public String ThemeDesc;
                    public String CoverUrl;
                    public String CoverThumbUrl;
                    public String IconUrl;
                    public List<?> ChildThemes;

                    @Override
                    public String toString() {
                        return "TourThemesEntity{" +
                                "TourThemeId=" + TourThemeId +
                                ", Title='" + Title + '\'' +
                                ", ThemeDesc='" + ThemeDesc + '\'' +
                                ", CoverUrl='" + CoverUrl + '\'' +
                                ", CoverThumbUrl='" + CoverThumbUrl + '\'' +
                                ", IconUrl='" + IconUrl + '\'' +
                                ", ChildThemes=" + ChildThemes +
                                '}';
                    }
                }

                public static class MemberListEntity {
                    public String UUID;
                    public String Telephone;
                    public String Nick;
                    public int Sex;
                    public String AvatarThumbUrl;
                    public int Age;
                    public String Signature;
                    public int FavorNum;
                    public int FansNum;
                    public int IsTourGuideVerify;
                    public int IsCarVerify;
                    public int IsIdentify;
                    public int IsFavored;
                    public int IsValid;
                    public String LivingPlace;
                    public String OpenfireAccount;
                    public String Professional;


                    @Override
                    public String toString() {
                        return "MemberListEntity{" +
                                "UUID='" + UUID + '\'' +
                                ", Telephone='" + Telephone + '\'' +
                                ", Nick='" + Nick + '\'' +
                                ", Sex=" + Sex +
                                ", AvatarThumbUrl='" + AvatarThumbUrl + '\'' +
                                ", Age=" + Age +
                                ", Signature='" + Signature + '\'' +
                                ", FavorNum=" + FavorNum +
                                ", FansNum=" + FansNum +
                                ", IsTourGuideVerify=" + IsTourGuideVerify +
                                ", IsCarVerify=" + IsCarVerify +
                                ", IsIdentify=" + IsIdentify +
                                ", IsFavored=" + IsFavored +
                                ", IsValid=" + IsValid +
                                ", LivingPlace='" + LivingPlace + '\'' +
                                ", OpenfireAccount='" + OpenfireAccount + '\'' +
                                ", Professional='" + Professional + '\'' +
                                '}';
                    }
                }

                public static class StageEntity {
                    public String PlanGuid;
                    public String StartTime;
                    public String EndTime;
                    public int Price;
                    public int Earnest;
                    public int JoinNumber;
                    public int TotalNumber;
                    public int IsMember;

                    @Override
                    public String toString() {
                        return "StageEntity{" +
                                "PlanGuid='" + PlanGuid + '\'' +
                                ", StartTime='" + StartTime + '\'' +
                                ", EndTime='" + EndTime + '\'' +
                                ", Price=" + Price +
                                ", Earnest=" + Earnest +
                                ", JoinNumber=" + JoinNumber +
                                ", TotalNumber=" + TotalNumber +
                                ", IsMember=" + IsMember +
                                '}';
                    }
                }
            }
        }
    }
}
