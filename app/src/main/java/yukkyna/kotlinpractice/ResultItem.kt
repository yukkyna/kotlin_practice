package yukkyna.kotlinpractice

import java.math.BigDecimal

data class ResultItem(val wrapperType: String, val kind: String, val artistId: String, val collectionId: Long, val trackId: String,
                      val artistName: String, val collectionName: String, val trackName: String, val collectionCensoredName: String,
                      val trackCensoredName: String, val artistViewUrl: String, val collectionViewUrl: String,
                      val trackViewUrl: String, val previewUrl: String, val artworkUrl30: String,
                      val artworkUrl60: String, val artworkUrl100: String,
                      val collectionPrice: BigDecimal, val trackPrice: BigDecimal, val releaseDate: String,
                      val collectionExplicitness: String, val trackExplicitness: String, val discCount: Int,
                      val discNumber: Int, val trackCount: Int, val trackNumber: Int,
                      val trackTimeMillis: Long, val country: String, val currency: String,
                      val primaryGenreName: String, val isStreamable: Boolean)
