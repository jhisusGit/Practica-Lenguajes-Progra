import yt_dlp

def Descargar_Video(url):
    opciones = {
        'format': 'bestvideo+bestaudio/best',
        'progress_hooks': [ProgresoDescarga],
    }
    with yt_dlp.YoutubeDL(opciones) as ydl:
        ydl.download([url])



def Descargar_Audio(url):
    opciones = {                          
        'format': 'bestaudio/best',       
        'postprocessors': [{              
            'key': 'FFmpegExtractAudio',
            'preferredcodec': 'mp3',
            'preferredquality': '192',
        }],                               
        'progress_hooks': [ProgresoDescarga],  
    }                                    


def ProgresoDescarga(d):
    if d['status'] == 'downloading':
        print(f"Descargando: {d['_percent_str']} - {d['_speed_str']} - {d['_eta_str']}")
    elif d['status'] == 'finished':
        print("Descarga completada.")