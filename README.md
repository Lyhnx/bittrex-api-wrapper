# Bittrex API Wrapper
**Currently supported API versions: v1.1**

Easy to use wrapper for the Bittrex.com api


# How To Use
### Include the library
```xml
<dependency>
  <groupId>com.github.lyhnx</groupId>
  <artifactId>bittrex-api-wrapper</artifactId>
  <version>1.0.0</version>
</dependency>
```
 
 ### APIs
 ```java
 // Create a PublicApi Object to interact with Bittrex Public API
 final PublicApi api = new PublicApi();
 ... = api.getMarkets();
 
 // To use the Market and Account API you need to provide an API Key
 // Please note that your ApiKey is immuteable. If you want to change your ApiKey you'll have to create
 // another api instance
 final ApiKey apiKey = new ApiKey(myKey, mySecret);
 final MarketApi marketApi = new MarketApi(apiKey);
 final AccountApi accountApi = new AccountApi(apiKey);
``` 

# License
>Copyright 2017 Lyhnx
>
>Licensed under the Apache License, Version 2.0 (the "License");
>you may not use this file except in compliance with the License.
>You may obtain a copy of the License at
>
>   http://www.apache.org/licenses/LICENSE-2.0
>
>Unless required by applicable law or agreed to in writing, software
>distributed under the License is distributed on an "AS IS" BASIS,
>WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
>See the License for the specific language governing permissions and
>limitations under the License.
