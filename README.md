# mn-vnstat-json

A microservice build with [Micronaut](http://micronaut.io/) that delivers network traffic stats.
Uses [vnstat](https://humdi.net/vnstat/) to retrieve the statistics.

Provided endpoints:

> GET /

Will deliver the whole vnstat db in json.

```
{
  "vnstatversion": "1.18",
  "jsonversion": "1",
  "interfaces": [
    {
      "id": "eth0",
      ...
	},
     {
      "id": "tun0",
      ...
    }
  ]
}
```


> GET /bridge0

If available, will deliver the stats for the provided interface

```
{
  "vnstatversion": "1.18",
  "jsonversion": "1",
  "interfaces": [
    {
      "id": "bridge0",
      ...
	}
  ]
}
```