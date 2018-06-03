package io.topalski.utils

import io.micronaut.http.HttpResponse


class VnstatWrapper
{
    def static notFound = { String iface -> "{ \"error\": \"$iface not found\" }" }

    static getAll()
    {
        //Execute and retrieve vnstat information
        "vnstat --json".execute().text
    }

    static HttpResponse getInterface(String iface)
    {
        //Default not found response
        def response = HttpResponse.notFound().body(notFound(iface))

        //Get a list of all available network interfaces
        def list = "ls /sys/class/net".execute().text.readLines()
        if (list.contains(iface))
        {
            def txt = "vnstat -i $iface --json".execute().text

            //Ensure that the interface is monitored by vnstat
            if (!txt.contains('Error'))
                response = HttpResponse.ok().body(txt)
        }

        return response
    }
}
