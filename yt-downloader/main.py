from downloader import Descargar_Video, Descargar_Audio, ProgresoDescarga

def main():
    print("[1]. Descargar video\n[2]. Descargar audio")
    m = input("Elige la opcion: ")
    if m == "1":    
        url = input("Ingrese la URL del video: ")
        Descargar_Video(url)
    elif m == "2":
        url = input("Ingrese la URL del video: ")
        Descargar_Audio(url)


main()

