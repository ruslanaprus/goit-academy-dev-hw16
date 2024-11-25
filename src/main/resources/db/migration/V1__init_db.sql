CREATE SEQUENCE IF NOT EXISTS seq_notes_id
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS notes (
    id BIGINT DEFAULT nextval('seq_notes_id'),
    title VARCHAR(255) NOT NULL CHECK (length(title) > 0),
    content TEXT NOT NULL,
    CONSTRAINT pk_notes_id PRIMARY KEY (id)
    );
