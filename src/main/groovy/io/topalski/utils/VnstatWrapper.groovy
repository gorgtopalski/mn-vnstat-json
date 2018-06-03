package io.topalski.utils

import io.micronaut.http.HttpResponse


class VnstatWrapper
{
    def static notFound = { String iface -> "{ \"error\": \"$iface not found\" }" }

    static getAll()
    {
        "vnstat --json".execute().text
    }

    static HttpResponse getInterface(String iface)
    {
        def response = HttpResponse.notFound().body(notFound(iface))

        def list = "ls /sys/class/net".execute().text.readLines()
        if (list.contains(iface))
        {
            def txt = "vnstat -i $iface --json".execute().text

            if (!txt.contains('Error'))
                response = HttpResponse.ok().body(txt)
        }

        return response
    }
}
