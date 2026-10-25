CREATE SEQUENCE clientes_codigo_seq;

CREATE TABLE clientes (
    tipo_pessoa VARCHAR(8) NOT NULL CHECK (tipo_pessoa IN ('FISICA', 'JURIDICA')),
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo BIGINT NOT NULL UNIQUE DEFAULT nextval('clientes_codigo_seq'),
    cpf VARCHAR(11) UNIQUE NOT NULL CHECK (cpf ~ '^[0-9]{11}$'),
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(9) NOT NULL CHECK (sexo IN ('FEMININO', 'MASCULINO')),
    nacionalidade VARCHAR(100),
    rg VARCHAR(20),
    orgao_emissor VARCHAR(20),
    data_emissao_rg DATE,
    profissao VARCHAR(100),
    estado_civil VARCHAR(30) CHECK (estado_civil IN ('SOLTEIRO', 'CASADO', 'SEPARADO_JUDICIALMENTE', 'DIVORCIADO', 'VIUVO', 'UNIAO_ESTAVEL')),
    cep VARCHAR(8) NOT NULL CHECK (cep ~ '^[0-9]{8}$'),
    numero VARCHAR(10) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL CHECK (uf ~ '^[A-Z]{2}$'),
    municipio VARCHAR(100) NOT NULL,
    complemento VARCHAR(255),
    criado_em TIMESTAMPTZ NOT NULL,
    atualizado_em TIMESTAMPTZ NOT NULL
);