# TourMate

Tourist places website with:
- Sign Up / Sign In (Spring Security, sessions)
- Home page listing places (Bootstrap cards)
- Bottom-right chat widget calling Gemini via Spring AI
- Places CRUD (list, add, edit, delete) using JPA + MySQL
- Thymeleaf templates with Bootstrap 5 styling

## Quick start
1. Create a MySQL DB `tourmate` and update `src/main/resources/application.properties` with credentials.
2. Configure Spring AI Vertex Gemini: set `project-id`, `location`, and credentials (ADC or `credentials-uri`).
3. Build & run:
   ```bash
   mvn spring-boot:run
   ```
4. Open http://localhost:8080

## Notes
- Default demo places seed on first run.
- CSRF tokens are included in CRUD forms.
- Chat endpoint: `POST /api/chat` with JSON `{ "message": "..." }`.
- Replace images in `src/main/resources/static/images/` for better visuals.
