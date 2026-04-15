# Farm-to-Door Wholesale & Subscription Web App

A full-stack web application that connects local farmers directly with consumers and businesses.

## Tech Stack

| Layer | Technology |
|---|---|
| Frontend | HTML5, CSS3, Vanilla JavaScript |
| Backend | Java 21, Spring Boot 3.5.3 |
| Database | MySQL 8+ |
| Security | Spring Security 6 + BCrypt |
| Build Tool | Maven |

## Project Structure

```
Farm-to-Door/
├── frontend/               # Static HTML/CSS/JS frontend
│   ├── css/
│   │   ├── variables.css   # Design tokens (colors, spacing)
│   │   └── style.css       # Main stylesheet
│   ├── image/              # All image assets
│   ├── login.html
│   ├── signup.html
│   ├── main.html           # Home page (requires login)
│   ├── wholesale.html      # Wholesale market page
│   └── plan.html           # Subscription plans page
│
└── backend/
    └── foodapp/            # Spring Boot application
        ├── src/main/java/com/foodapp/
        │   ├── config/     # SecurityConfig
        │   ├── controller/ # REST Controllers
        │   ├── model/      # JPA Entities (User, Subscription)
        │   └── repository/ # Spring Data Repositories
        ├── src/main/resources/
        │   └── application.properties
        └── pom.xml
```

## How to Run

### Prerequisites
- Java 21
- MySQL 8+
- Python 3 (for frontend server)

### 1. Database Setup
```sql
CREATE DATABASE fooddb;
```

### 2. Start Backend
```powershell
cd backend/foodapp
.\mvnw spring-boot:run
```
Backend runs on: `http://localhost:8080`

### 3. Start Frontend
```powershell
cd frontend
python -m http.server 3000
```
Open: `http://localhost:3000/login.html`

## Environment Variables (Optional)
Set these to override default DB credentials:
- `DB_USERNAME` (default: `root`)
- `DB_PASSWORD` (default: value in properties)
