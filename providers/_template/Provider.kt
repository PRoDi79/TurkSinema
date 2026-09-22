package com.mgg.turksinema.providers

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

/**
 * TurkSinema sade provider standardi.
 *
 * Kurallar:
 * - Wiojelt/WioCore/WioPoll bagimliligi yok.
 * - Gereksiz ayar, tarama, anket veya telemetry yok.
 * - Domain tek bir yerde tutulur ve gerekiyorsa ayri domain metadata'si ile yonetilir.
 * - Sadece sitenin gercekten sundugu media tipleri desteklenir.
 * - Trailer loadLinks icinde degil, LoadResponse trailer alaninda tutulur.
 * - Playback icin gereken referer/origin/cookie bilgileri korunur.
 * - Kaynak degisikliginde version mutlaka bir ust sayiya cikar.
 * - Guncellenen provider metadata'sinda gelistirici mgg olarak belirtilir.
 */
class Provider : MainAPI() {
    override var mainUrl = "https://CHANGE-ME"
    override var name = "Provider"
    override var lang = "tr"
    override val hasMainPage = true
    override val hasQuickSearch = true
    override val supportedTypes = setOf(TvType.Movie, TvType.TvSeries)

    override val mainPage = mainPageOf(
        // "${mainUrl}/..." to "Kategori"
    )

    override suspend fun getMainPage(
        page: Int,
        request: MainPageRequest
    ): HomePageResponse {
        val document = app.get(request.data).document
        val items = document.select("TODO").mapNotNull { element ->
            // Siteye ozel SearchResponse burada uretilir.
            null
        }
        return newHomePageResponse(request.name, items)
    }

    override suspend fun search(query: String): List<SearchResponse> {
        return emptyList()
    }

    override suspend fun load(url: String): LoadResponse? {
        return null
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        return false
    }
}
