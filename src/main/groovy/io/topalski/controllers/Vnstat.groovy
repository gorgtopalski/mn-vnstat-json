package io.topalski.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.topalski.utils.VnstatWrapper

@Controller("/")
class Vnstat
{
    @Get("/")
    String index()
    {
        return VnstatWrapper.getAll()
    }

    @Get("/{iface}")
    HttpResponse get(String iface)
    {
        return VnstatWrapper.getInterface(iface)
    }
}
