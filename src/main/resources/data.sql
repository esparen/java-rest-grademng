INSERT INTO public.alunos (data_nascimento, nome) VALUES
    (NULL, 'Fulano'),
    (NULL, 'Ciclano'),
    (NULL, 'Beltrano');
INSERT INTO public.professores (nome) VALUES
    ('Prof Aristóteles'),
    ('Prof Platão');
INSERT INTO public.disciplinas (nome, professor_id) VALUES
    ('Disc Teste', (SELECT id FROM public.professores ORDER BY id LIMIT 1)),
    ('Disc Filosofia', (SELECT id FROM public.professores ORDER BY id LIMIT 1));
