import speech_recognition as sr
import os

r = sr.Recognizer()
while True:
    with sr.Microphone() as source:
        print("Hola, soy tu asistente por voz:")
        try:
            # Ajuste del tiempo de espera y tiempo de escucha
            audio = r.listen(source, phrase_time_limit=5)
            text = r.recognize_google(audio, language="es-ES")
            print("Has dicho: {}".format(text))
            if "abrir Steam" in text:
                print("Abriendo Steam...")
                os.system("start steam://open")
            else:
                pass
                
        except sr.WaitTimeoutError:
            print("No se detectó ningún sonido, intenta de nuevo.")
        except sr.UnknownValueError:
            print("No te he entendido.")
        except sr.RequestError:
            print("No se pudo conectar con el servicio de reconocimiento de voz.")
