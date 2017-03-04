# ebaysdkcore
[![Build Status](https://travis-ci.org/tonicsoft/ebaysdkcore.svg?branch=master)](https://travis-ci.org/tonicsoft/ebaysdkcore)

`ebaysdkcore`, also known as the "eBay SDK for Java" provides convenient access to the eBay Trading API. It contains code generated from the Trading API WSDL and a thin wrapper which simplify common tasks like providing credentials or setting commonly used parameters.

This project aims to provide a reliable build of the official eBay source code releases for the eBay SDK for Java, conventiently distributed via the Maven Central Repository, with minimal differences to the binaries found in the official eBay downloads.

# download
Find the latest version of the project in the [Maven Central Repository](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.tonicsoft.ebay%22%20AND%20a%3A%22ebaysdkcore%22).

# useful links
 - [eBay SDK for Java](https://go.developer.ebay.com/javasdk) - eBay web site for the Java SDK. Here you will find all the documentation and getting starting guides relevant to this project. Official eBay releases can also be downloaded from here.
 - [Getting Started Guide](http://developer.ebay.com/DevZone/javasdk-jaxb/docs/GettingStarted/GettingStarted.html) - instructions for how to get up and running with this project.
 - [Trading API reference](http://developer.ebay.com/Devzone/XML/docs/Reference/eBay/index.html) - API reference for the Trading API, which is the API covered by this SDK (software development kit). The API can also be used without this SDK of course as it is simply a SOAP web service.
 - [Trading API release notes](http://developer.ebay.com/Devzone/XML/docs/ReleaseNotes.html) - find details about what features of the API will be supported by different versions of this SDK.
 - [eBay developers program home](https://go.developer.ebay.com/) - Main site for all resources related to the eBay APIs. Here you can sign up to the eBay Developers Program and gain access to the eBay API.
 - [eBay Shopping API](https://github.com/tonicsoft/ebay-shopping-api) - JAX-WS classes for the eBay Shopping API.

# versioning
Major versions are maintained in a one to one correspondance with the versions of releases made available on the eBay Developer Program website. For example, version `981.0.0` of this project would be a build of Version 981 of the eBay release. Subsequent minor or patch versions of this projects (`981.0.1`, `981.1.0` etc) represent builds from the same eBay source code. eBay maintains a one to one correspondence between versions of the SDK and versions of the Trading API.

# monkey patches
A small number of changes are maintained in order to make the artifacts more suitable for distribution via Maven:
 - Declared compile dependencies on `log4j:log4fj` and `commons-logging:commons-logging` have been removed to allow users of this project to select their own logging implementation, as the eBay source code uses `org.slf4j:slf4j-api` exculsively.
 - JAX-WS Code generation from the WSDL is done with a Maven plugin (`jaxws-maven-plugin`) instead of running the Ant task `com.sun.tools.ws.ant.WsImport` via the Maven plugin `maven-antrun-plugin`. This is to prevent hard coded file system paths for `wsdlLocation` ending up in the generated source code (see [Stack Overflow](http://stackoverflow.com/questions/9802487/controlling-jax-ws-wsdllocation-attribute-values-absolute-path-with-jaxws-mav))
 - The provided WSDL `eBaySvc.wsdl` is packaged inside eBay's namespace `com.ebay.sdk` instead of at the root of the classpath. If you need to load the WSDL from the classpath, you can use `"com/ebay/sdk/eBaySvc.wsdl"` instead of `"eBaySvc.wsdl"` as the path.
