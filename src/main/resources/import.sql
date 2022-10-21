INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (0, '07:30', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (2, '09:10', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (1, '08:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (3, '10:10', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (4, '11:00 - 11:50', true);

INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (5, '13:30', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (6, '14:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (7, '15:10', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (8, '16:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (9, '17:10 - 18:00', true);

INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (10, '18:30', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (11, '19:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (12, '20:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (13, '21:10 - 22:00', false);

INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (0, 'Segunda-feira');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (1, 'Terça-feira');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (2, 'Quarta-feira');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (3, 'Quinta-feira');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (4, 'Sexta-feira');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (5, 'Sábado');

INSERT INTO TB_PROFESSOR (id, nome) VALUES (1, 'Pedro da Paz');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (2, 'Laura Barros');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (3, 'Maria Vitória da Cunha');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (4, 'Alexandre Souza');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (5, 'Helena Lopes');

INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('EEL5105', 90, 'Circuitos e Técnicas Digitais');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5401', 36, 'Introdução à Computação');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5402', 108, 'Programação Orientada a Objetos I');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5403', 108, 'Fundamentos de Matemática Discreta para Computação');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('MTM3100', 72, 'Pré-Cálculo');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('MTM3101', 72, 'Cálculo 1');

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01208A', 1, 'EEL5105', 1);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01208B', 1, 'EEL5105', 2);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03202A', 1, 'INE5401', 3);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03202B', 1, 'INE5401', 3);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03208A', 1, 'INE5402', 2);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('3208B', 1, 'INE5402', 4);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01205D', 1, 'INE5403', 1);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01205C', 1, 'INE5403', 4);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('08213', 1, 'MTM3100', 4);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03235', 1, 'MTM3101', 4);

-- TODO: Arrumar os horários depois para ter conflitos !
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'LABSDG', 2, 1);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'EFI204', 1, 2);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'EFI203', 1, 3);

INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208B', 'CTC304', 1, 2);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('01208B', 'CTC304', 2, 4, 6);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('01208B', 'LABSDG', 4, 1, 3);
--
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03202A', 'CTC304', 1, 2, 4);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03202A', 'CTC304', 2, 4, 6);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03202A', 'LABSDG', 4, 1, 3);
--
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03202B', 'CTC304', 1, 2, 4);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03202B', 'CTC304', 2, 4, 6);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03202B', 'LABSDG', 4, 1, 3);
--
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('01205D', 'CTC304', 1, 2, 4);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('01205D', 'CTC304', 2, 4, 6);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('01205D', 'LABSDG', 4, 1, 3);
--
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('01205C', 'CTC304', 1, 2, 4);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('01205C', 'CTC304', 2, 4, 6);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('01205C', 'LABSDG', 4, 1, 3);
--
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('08213', 'CTC304', 1, 2, 4);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('08213', 'CTC304', 2, 4, 6);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('08213', 'LABSDG', 4, 1, 3);
--
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03235', 'CTC304', 1, 2, 4);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03235', 'CTC304', 2, 4, 6);
--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_inicio_id, horario_final_id) VALUES ('03235', 'LABSDG', 4, 1, 3);