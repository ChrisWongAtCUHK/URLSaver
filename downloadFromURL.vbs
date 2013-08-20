dim xHttp: Set xHttp = createobject("Microsoft.XMLHTTP")
dim bStrm: Set bStrm = createobject("Adodb.Stream")
xHttp.Open "GET", "http://www.enginsite.com/GCC-Builder/gcc-builder-full.gif", False
xHttp.Send

with bStrm
    .type = 1 '//binary
    .open
    .write xHttp.responseBody
    .savetofile "D:\tmp\gcc-builder-full.gif", 2 '//overwrite
end with