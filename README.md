# Documentazione API REST CorsiOnline

Questo documento descrive gli endpoint dell'API REST per l'applicazione CorsiOnline. Tutti gli endpoint utilizzano JSON per i corpi delle richieste e delle risposte. L'URL di base per tutti gli endpoint è `http://localhost:8080/api/v1/`.  Tutti gli endpoint supportano CORS da `http://localhost:5173/`.  Gli ID sono di tipo Long.


## Endpoint

### 1. Utenti (Users)

* **URL di base:** `/utenti`

| Metodo | Endpoint          | Descrizione                                      | Corpo Richiesta                     | Corpo Risposta          | Codici di Stato |
|--------|----------------------|--------------------------------------------------|---------------------------------|-----------------------|---------------|
| `GET`  | `/`                 | Recupera tutti gli utenti.                            | Nessuno                             | List<UtenteDTO>         | 200            |
| `GET`  | `/{id}`             | Recupera un utente per ID.                           | Nessuno                             | UtenteDTO              | 200, 404       |
| `GET`  | `/{id}/classi`      | Recupera le classi associate ad un utente (studente). | Nessuno                             | List<ClasseDTO>         | 200, 404       |
| `GET`  | `/{id}/esami`       | Recupera gli esami associati ad un utente.           | Nessuno                             | List<EsameDTO>         | 200, 404       |
| `POST` | `/`                 | Crea un nuovo utente.                              | Utente                           | UtenteDTO              | 201            |
| `PUT`  | `/{id}`             | Aggiorna un utente per ID.                            | Utente                           | Nessuno                   | 200, 404       |
| `DELETE`| `/{id}`             | Elimina un utente per ID.                            | Nessuno                             | Nessuno                   | 204, 404       |


### 2. Corsi (Courses)

* **URL di base:** `/corsi`

| Metodo | Endpoint          | Descrizione                               | Corpo Richiesta          | Corpo Risposta          | Codici di Stato |
|--------|----------------------|-------------------------------------------|-----------------------|-----------------------|---------------|
| `GET`  | `/`                 | Recupera tutti i corsi.                     | Nessuno                   | List<CorsoDTO>         | 200            |
| `GET`  | `/{id}`             | Recupera un corso per ID.                  | Nessuno                   | CorsoDTO              | 200, 404       |
| `GET`  | `/{id}/classi`      | Recupera le classi associate ad un corso. | Nessuno                   | List<ClasseDTO>         | 200, 404       |
| `POST` | `/`                 | Crea un nuovo corso.                      | Corso                  | CorsoDTO              | 201            |
| `PUT`  | `/{id}`             | Aggiorna un corso per ID.                   | Corso                  | Nessuno                   | 200, 404       |
| `DELETE`| `/{id}`             | Elimina un corso per ID.                    | Nessuno                   | Nessuno                   | 204, 404       |


### 3. Classi (Classes)

* **URL di base:** `/classi`

| Metodo | Endpoint          | Descrizione                                         | Corpo Richiesta                     | Corpo Risposta          | Codici di Stato |
|--------|----------------------|-----------------------------------------------------|---------------------------------|-----------------------|---------------|
| `GET`  | `/`                 | Recupera tutte le classi.                              | Nessuno                             | List<ClasseDTO>         | 200            |
| `GET`  | `/{id}`             | Recupera una classe per ID.                             | Nessuno                             | ClasseDTO              | 200, 404       |
| `GET`  | `/{id}/lezioni`     | Recupera le lezioni associate ad una classe.           | Nessuno                             | List<LezioneDTO>        | 200, 404       |
| `GET`  | `/{id}/studenti`    | Recupera gli studenti associati ad una classe.          | Nessuno                             | List<UtenteDTO>         | 200, 404       |
| `PUT`  | `/{id}/studenti`    | Aggiunge studenti ad una classe.                           | List<UtenteDTO>                 | Nessuno                   | 200, 404       |
| `GET`  | `/{id}/eventi`      | Recupera gli eventi associati ad una classe.            | Nessuno                             | List<EventoDTO>         | 200, 404       |
| `GET`  | `/{id}/esami`       | Recupera gli esami associati ad una classe.            | Nessuno                             | List<EsameDTO>         | 200, 404       |
| `POST` | `/`                 | Crea una nuova classe.                               | Classe                          | ClasseDTO              | 201            |
| `PUT`  | `/{id}`             | Aggiorna una classe per ID.                            | Classe                          | Nessuno                   | 200, 404       |
| `DELETE`| `/{id}`             | Elimina una classe per ID.                             | Nessuno                             | Nessuno                   | 204, 404       |


### 4. Lezioni (Lessons)

* **URL di base:** `/lezioni`

| Metodo | Endpoint          | Descrizione                                      | Corpo Richiesta                     | Corpo Risposta          | Codici di Stato |
|--------|----------------------|--------------------------------------------------|---------------------------------|-----------------------|---------------|
| `GET`  | `/`                 | Recupera tutte le lezioni.                           | Nessuno                             | List<LezioneDTO>        | 200            |
| `GET`  | `/{id}`             | Recupera una lezione per ID.                          | Nessuno                             | LezioneDTO             | 200, 404       |
| `GET`  | `/{id}/materiali`   | Recupera i materiali associati ad una lezione.     | Nessuno                             | List<MaterialeDTO>       | 200, 404       |
| `PUT`  | `/{id}/materiali`   | Aggiunge materiali ad una lezione.                       | List<MaterialeDTO>                 | Nessuno                   | 200, 404       |
| `POST` | `/`                 | Crea una nuova lezione.                             | Lezione                          | LezioneDTO             | 201            |
| `PUT`  | `/{id}`             | Aggiorna una lezione per ID.                           | Lezione                          | Nessuno                   | 200, 404       |
| `DELETE`| `/{id}`             | Elimina una lezione per ID.                            | Nessuno                             | Nessuno                   | 204, 404       |


### 5. Materiali (Materials)

* **URL di base:** `/materiali`

| Metodo | Endpoint          | Descrizione                               | Corpo Richiesta          | Corpo Risposta          | Codici di Stato |
|--------|----------------------|-------------------------------------------|-----------------------|-----------------------|---------------|
| `GET`  | `/`                 | Recupera tutti i materiali.                   | Nessuno                   | List<MaterialeDTO>       | 200            |
| `GET`  | `/{id}`             | Recupera un materiale per ID.                | Nessuno                   | MaterialeDTO             | 200, 404       |
| `POST` | `/`                 | Crea un nuovo materiale.                    | Materiale             | MaterialeDTO             | 201            |
| `PUT`  | `/{id}`             | Aggiorna un materiale per ID.                 | Materiale             | Nessuno                   | 200, 404       |
| `DELETE`| `/{id}`             | Elimina un materiale per ID.                  | Nessuno                   | Nessuno                   | 204, 404       |


### 6. Esami (Exams)

* **URL di base:** `/esami`

| Metodo | Endpoint          | Descrizione                               | Corpo Richiesta          | Corpo Risposta          | Codici di Stato |
|--------|----------------------|-------------------------------------------|-----------------------|-----------------------|---------------|
| `GET`  | `/`                 | Recupera tutti gli esami.                       | Nessuno                   | List<EsameDTO>         | 200            |
| `GET`  | `/{id}`             | Recupera un esame per ID.                   | Nessuno                   | EsameDTO              | 200, 404       |
| `POST` | `/`                 | Crea un nuovo esame.                        | Esame                  | EsameDTO              | 201            |
| `PUT`  | `/{id}`             | Aggiorna un esame per ID.                    | Esame                  | Nessuno                   | 200, 404       |
| `DELETE`| `/{id}`             | Elimina un esame per ID.                     | Nessuno                   | Nessuno                   | 204, 404       |


### 7. Eventi (Events)

* **URL di base:** `/eventi`

| Metodo | Endpoint          | Descrizione                               | Corpo Richiesta          | Corpo Risposta          | Codici di Stato |
|--------|----------------------|-------------------------------------------|-----------------------|-----------------------|---------------|
| `GET`  | `/`                 | Recupera tutti gli eventi.                      | Nessuno                   | List<EventoDTO>         | 200            |
| `GET`  | `/{id}`             | Recupera un evento per ID.                  | Nessuno                   | EventoDTO              | 200, 404       |
| `POST` | `/`                 | Crea un nuovo evento.                       | Evento                 | EventoDTO              | 201            |
| `PUT`  | `/{id}`             | Aggiorna un evento per ID.                    | Evento                 | Nessuno                   | 200, 404       |
| `DELETE`| `/{id}`             | Elimina un evento per ID.                     | Nessuno                   | Nessuno                   | 204, 404       |

figma
https://www.figma.com/design/XDNoUXLskiRFQ7Bs1D78Sw/Untitled?node-id=1-10&t=cbjkx39PgOQHgUVO-0