package com.hfad.popularlibrariesrxjava2dagger2moxy.test.view

import com.hfad.popularlibrariesrxjava2dagger2moxy.test.model.SearchResult

internal interface ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}
