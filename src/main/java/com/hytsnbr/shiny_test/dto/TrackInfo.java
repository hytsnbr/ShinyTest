package com.hytsnbr.shiny_test.dto;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/** 楽曲情報 */
@JsonDeserialize(builder = TrackInfo.TrackInfoBuilder.class)
@JsonPropertyOrder({
    "trackName",
    "trackNo",
    "isOffVocal",
    "isVoiceDrama"
})
public class TrackInfo {
    
    /** 楽曲名 */
    private final String trackName;
    
    /** トラックNo */
    private final int trackNo;
    
    /** オフボーカル版か */
    @JsonProperty("isOffVocal")
    private final boolean isOffVocal;
    
    /** オーディオドラマか */
    @JsonProperty("isVoiceDrama")
    private final boolean isVoiceDrama;
    
    /** ビルダークラス用コンストラクタ（プライベート） */
    private TrackInfo(TrackInfoBuilder builder) {
        this.trackName = builder.trackName;
        this.trackNo = builder.trackNo;
        this.isOffVocal = builder.isOffVocal;
        this.isVoiceDrama = builder.isVoiceDrama;
    }
    
    /** ビルダー */
    public static TrackInfoBuilder builder() {
        return new TrackInfoBuilder();
    }
    
    @SuppressWarnings("unused")
    public String getTrackName() {
        return trackName;
    }
    
    @SuppressWarnings("unused")
    public int getTrackNo() {
        return trackNo;
    }
    
    @JsonGetter("isOffVocal")
    public boolean isOffVocal() {
        return isOffVocal;
    }
    
    @JsonGetter("isVoiceDrama")
    public boolean isVoiceDrama() {
        return isVoiceDrama;
    }
    
    // NOTE: 未定義の場合 SonarLint が警告を出すので対策として定義
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TrackInfo trackInfo)) {
            return super.equals(obj);
        }
        
        if (!StringUtils.equals(this.trackName, trackInfo.trackName)) return false;
        if (this.trackNo != trackInfo.trackNo) return false;
        if (this.isOffVocal != trackInfo.isOffVocal) return false;
        return this.isVoiceDrama == trackInfo.isVoiceDrama;
    }
    
    /** ビルダークラス */
    @JsonPOJOBuilder(withPrefix = "")
    public static class TrackInfoBuilder {
        
        private String trackName;
        
        private int trackNo;
        
        private boolean isOffVocal;
        
        private boolean isVoiceDrama;
        
        /** 楽曲名 */
        public TrackInfoBuilder trackName(String trackName) {
            this.trackName = trackName;
            return this;
        }
        
        /** トラックNo */
        public TrackInfoBuilder trackNo(int trackNo) {
            this.trackNo = trackNo;
            return this;
        }
        
        /** オフボーカル版か */
        @JsonProperty("isOffVocal")
        public TrackInfoBuilder isOffVocal(boolean isOffVocal) {
            this.isOffVocal = isOffVocal;
            return this;
        }
        
        /** オーディオドラマか */
        @JsonProperty("isVoiceDrama")
        public TrackInfoBuilder isVoiceDrama(boolean isVoiceDrama) {
            this.isVoiceDrama = isVoiceDrama;
            return this;
        }
        
        /** ビルド */
        public TrackInfo build() {
            return new TrackInfo(this);
        }
    }
}