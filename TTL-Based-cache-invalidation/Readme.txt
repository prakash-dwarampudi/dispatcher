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
 
 How does it work
 1. When a page is accessed, it creates a .html page in htdocs
 2. Along with the page, it creates a .ttl blank page with timestamp equal to currenttime+ expire-time
 3. when /headers is enabled, it also create a .h file which is containing the response headers defined in the section
 
 