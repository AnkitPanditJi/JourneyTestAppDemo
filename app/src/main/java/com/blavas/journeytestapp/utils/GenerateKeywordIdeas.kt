package com.trendnxt.utils
/*
import com.trendnxt.utils.GenerateKeywordIdeas.GenerateKeywordIdeasParams
import com.google.ads.googleads.lib.GoogleAdsClient
import com.google.ads.googleads.v11.enums.KeywordPlanNetworkEnum
import com.google.ads.googleads.v11.errors.GoogleAdsException
import com.google.ads.googleads.v11.services.GenerateKeywordIdeasRequest
import com.google.ads.googleads.v11.utils.ResourceNames
import com.trendnxt.utils.GenerateKeywordIdeas
import java.io.FileNotFoundException
import java.io.IOException
import java.util.**/

class GenerateKeywordIdeas {
   /* var params: GenerateKeywordIdeasParams

    class GenerateKeywordIdeasParams {
        internal var customerId: Long? = null
        internal var locationIds: List<Long>? = null
        internal var languageId: Long? = null
        internal var keywords: List<String> = ArrayList()
        internal var pageUrl: String? = null
    }

    init {
        params = GenerateKeywordIdeasParams()
        // Either pass the required parameters for this example on the command line, or insert them
        // into the code here. See the parameter class definition above for descriptions.
        //Customer Id
        params.customerId =
            "65980519982-85gokcs5phq3nmc1asgqlde9hukiv6v8.apps.googleusercontent.com".toLong()
        // INSERT_LOCATION_ID_1_HERE
        //INSERT_LOCATION_ID_2_HERE
        params.locationIds = Arrays.asList("2356".toLong())
        //Language
        params.languageId = "1000".toLong()
        //INSERT_KEYWORD_1_HERE
        //INSERT_KEYWORD_2_HERE
        params.keywords = Arrays.asList("dance", "dance India")
        // Optional: Use a URL related to your business to generate ideas.
        params.pageUrl = null
        var googleAdsClient: GoogleAdsClient? = null
        try {
            googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build()
        } catch (fnfe: FileNotFoundException) {
            System.err.printf(
                "Failed to load GoogleAdsClient configuration from file. Exception: %s%n", fnfe)
            System.exit(1)
        } catch (ioe: IOException) {
            System.err.printf("Failed to create GoogleAdsClient. Exception: %s%n", ioe)
            System.exit(1)
        }
        try {
            GenerateKeywordIdeas()
                .runExample(
                    googleAdsClient,
                    params.customerId!!,
                    params.languageId!!,
                    params.locationIds,
                    params.keywords,
                    params.pageUrl)
        } catch (gae: GoogleAdsException) {
            // GoogleAdsException is the base class for most exceptions thrown by an API request.
            // Instances of this exception have a message and a GoogleAdsFailure that contains a
            // collection of GoogleAdsErrors that indicate the underlying causes of the
            // GoogleAdsException.
            System.err.printf(
                "Request ID %s failed due to GoogleAdsException. Underlying errors:%n",
                gae.requestId)
            var i = 0
            for (googleAdsError in gae.googleAdsFailure.errorsList) {
                System.err.printf("  Error %d: %s%n", i++, googleAdsError)
            }
            System.exit(1)
        }
    }

    *//**
     * Runs the example.
     *
     * @param googleAdsClient the Google Ads API client.
     * @param customerId the client customer ID.
     * @param languageId the language ID.
     * @param locationIds the location IDs.
     * @param keywords the list of keywords to use as a seed for ideas.
     * @param pageUrl optional URL related to your business to use as a seed for ideas.
     * @throws GoogleAdsException if an API request failed with one or more service errors.
     * @throws IllegalArgumentException if `keywords` is empty and `pageUrl` is null.
     * @throws Exception if the example failed due to other errors.
     *//*
    // [START generate_keyword_ideas]
    public fun runExample(
        googleAdsClient: GoogleAdsClient?,
        customerId: Long,
        languageId: Long,
        locationIds: List<Long>?,
        keywords: List<String>,
        pageUrl: String?
    ) {
        googleAdsClient!!.latestVersion.createKeywordPlanIdeaServiceClient()
            .use { keywordPlanServiceClient ->
                val requestBuilder = GenerateKeywordIdeasRequest.newBuilder()
                    .setCustomerId(java.lang.Long.toString(customerId)) // Sets the language resource using the provided language ID.
                    .setLanguage(ResourceNames.languageConstant(languageId)) // Sets the network. To restrict to only Google Search, change the parameter below to
                    // KeywordPlanNetwork.GOOGLE_SEARCH.
                    .setKeywordPlanNetwork(KeywordPlanNetworkEnum.KeywordPlanNetwork.GOOGLE_SEARCH_AND_PARTNERS)

                // Adds the resource name of each location ID to the request.
                for (locationId in locationIds!!) {
                    requestBuilder.addGeoTargetConstants(ResourceNames.geoTargetConstant(
                        locationId))
                }

                // Makes sure that keywords and/or page URL were specified. The request must have exactly one
                // of urlSeed, keywordSeed, or keywordAndUrlSeed set.
                require(!(keywords.isEmpty() && pageUrl == null)) { "At least one of keywords or page URL is required, but neither was specified." }
                if (keywords.isEmpty()) {
                    // Only page URL was specified, so use a UrlSeed.
                    requestBuilder.urlSeedBuilder.url = pageUrl
                } else if (pageUrl == null) {
                    // Only keywords were specified, so use a KeywordSeed.
                    requestBuilder.keywordSeedBuilder.addAllKeywords(keywords)
                } else {
                    // Both page URL and keywords were specified, so use a KeywordAndUrlSeed.
                    requestBuilder.keywordAndUrlSeedBuilder.setUrl(pageUrl).addAllKeywords(keywords)
                }

                // Sends the keyword ideas request.
                val response = keywordPlanServiceClient.generateKeywordIdeas(requestBuilder.build())
                // Prints each result in the response.
                for (result in response.iterateAll()) {
                    System.out.printf(
                        "Keyword idea text '%s' has %d average monthly searches and '%s' competition.%n",
                        result.text,
                        result.keywordIdeaMetrics.avgMonthlySearches,
                        result.keywordIdeaMetrics.competition)
                }
            }
    } // [END generate_keyword_ideas]*/
}