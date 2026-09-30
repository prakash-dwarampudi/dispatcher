1. Create Replication Agent on Author.
2. Create Flush agent on Publish or(create it on Author and replicate it to publisher).
3. Make sure On Receive Trigger is enabled for Flush agent on publish.

Note: If two publishers point to same dispatcher, it will issue the cache invalidation request twice
      from both the publishers.
      
Sample invalidation request:
----------------------------
GET /dispatcher/invalidate.cache HTTP/1.0
CQ-Action: Activate
CQ-Handle: /content/usa-cities/en/locations/orange-county/airport-area
CQ-Path: /content/usa-cities/en/locations/orange-county/airport-area