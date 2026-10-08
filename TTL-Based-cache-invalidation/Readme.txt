1. Create a sling Filter to add response headers
  Cache-Control: public, max-age=180
  
2. Deploy the bundle in Publish instance
3. At dispatcher level
   under /cache section
     /enableTTL "1"
   Also enable response headers forwarding
   
   /headers
        {
        "Cache-Control"
        "Content-Disposition"
        "Content-Type"
        "Expires"
        "Last-Modified"
        "X-Content-Type-Options"
        }
 4. restart apache
 
 Q) How does TTL based caching work?
 1. When a page is accessed, it creates a .html page in htdocs
 2. Along with the page, it creates a .ttl blank page with timestamp equal to currenttime+ expire-time
 3. when /headers is enabled, it also create a .h file which is containing the response headers defined in the section
 
 
 Q2) Can you give me a practical example for caching response headers using .h files?
 
Suppose your AEM Publish instance exposes an API endpoint (e.g., Content Fragments via GraphQL or JSON export) or serves brand assets (e.g., SVG icons, custom web fonts) located at:
/content/dam/mysite/icons/brand-logo.svg

Your standalone Single Page Application (SPA), running on a different domain ([https://app.mycompany.com](https://app.mycompany.com)), needs to fetch this SVG asset via fetch() or render it inside a dynamic canvas on the user's browser.

To allow cross-origin access, an AEM OSGi service or Sling Filter adds CORS headers to the response:
Access-Control-Allow-Origin: [https://app.mycompany.com](https://app.mycompany.com)

Access-Control-Allow-Methods: GET, OPTIONS

1. First request Hit the Publisher and the response headers are added by AEM Publish
2. If /headers is not enabled,
   For susequent request, the svg file is fetched from cache and no response headers would be added
   So Browser would treat it as CORS error, since headers are not present
   
 
 