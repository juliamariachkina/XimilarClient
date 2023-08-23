# Ximilar API Java Client

Created as a solution to the home assignment for Ximilar backend position, this repository provides a part of Ximilar API Client in Java. This solution implements all of the requirements (listed below).

########## Part of the assignment ###########

Create a Java package that would communicate with part of the Ximilar API as documented at https://docs.ximilar.com.
Specifically, communication with two services is required:
1. Image categorization & tagging: https://docs.ximilar.com/services/recognition/
2. Image similarity: https://docs.ximilar.com/services/similarity_search/
The base of the package should be the same for all services:
* authentication via API token,
* base URL of Ximilar API endpoints (api.ximilar.com or api.dev.ximilar.com),
* encapsulation of low-level API calls, getting response and handling of errors,
* basic work with JSON data (for both request and response),
* work with string constants that are repeatedly used in the API calls,
* working with Ximilar "workspaces" of given user,
* basic work with local images (read it and convert to base64 for API transfer),
* work with image records: take a list of image records, split them into batches of 10 records (parameter) and calling of given API method in parallel (given number of threads that call the API method, each with a batch of records).

-> Image categorization and tagging

The following functionality (API methods) are to be implemented:
* calling a categorization/tagging task (model) to process an image (or batch of images): Categorization & Tagging - Ximilar API(images can be either from local storage or specified by URL),
* inserting training images into workspace of given user: https://docs.ximilar.com/services/recognition/#training-image-endpoint-v2 training-image

-> Image similarity

There are several services with the same API (product sim., product sim., image matching, custom similarity) and they differ only in API prefix. We recommend implementing one abstract base class for image similarity and then specific classes for each sub-service that will differ only in the API prefix.
The following functionality (API methods) are to be implemented:
* insert batch of images (local or URLs) into a collection: https://docs.ximilar.com/services/similarity_search/#v2insert
* get "k" visually similar image to a query image: https://docs.ximilar.com/services/similarity_search/#v2visualknn
