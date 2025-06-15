
-- Crear tabla de planes de suscripción
CREATE TABLE planes_suscripcion (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio NUMERIC(12, 2) NOT NULL,
    limite_usuarios INT NOT NULL,
    limite_documentos INT NOT NULL
);

-- Crear tabla de empresas
CREATE TABLE empresas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nit VARCHAR(20) UNIQUE NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    plan_suscripcion_id INT REFERENCES planes_suscripcion(id)
);

-- Crear tabla de usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash TEXT NOT NULL,
    empresa_id INT REFERENCES empresas(id) ON DELETE CASCADE,
    rol VARCHAR(50) CHECK (rol IN ('admin', 'contador')) NOT NULL
);

-- Crear tabla de cuentas contables
CREATE TABLE cuentas (
    id SERIAL PRIMARY KEY,
    empresa_id INT REFERENCES empresas(id) ON DELETE CASCADE,
    codigo VARCHAR(10) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) CHECK (tipo IN ('activo', 'pasivo', 'patrimonio', 'ingreso', 'gasto')) NOT NULL,
    nivel INT CHECK (nivel BETWEEN 1 AND 5),
    cuenta_padre_id INT REFERENCES cuentas(id)
);

-- Crear tabla de asientos contables
CREATE TABLE asientos (
    id SERIAL PRIMARY KEY,
    empresa_id INT REFERENCES empresas(id) ON DELETE CASCADE,
    fecha DATE NOT NULL,
    descripcion TEXT,
    usuario_id INT REFERENCES usuarios(id)
);

-- Crear tabla de detalles de asientos
CREATE TABLE asiento_detalles (
    id SERIAL PRIMARY KEY,
    asiento_id INT REFERENCES asientos(id) ON DELETE CASCADE,
    cuenta_id INT REFERENCES cuentas(id),
    debito NUMERIC(12, 2) DEFAULT 0,
    credito NUMERIC(12, 2) DEFAULT 0
);

-- Crear tabla de clientes
CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    empresa_id INT REFERENCES empresas(id) ON DELETE CASCADE,
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(20),
    direccion VARCHAR(200),
    telefono VARCHAR(20)
);

-- Crear tabla de facturas
CREATE TABLE facturas (
    id SERIAL PRIMARY KEY,
    empresa_id INT REFERENCES empresas(id) ON DELETE CASCADE,
    cliente_id INT REFERENCES clientes(id),
    fecha_emision DATE NOT NULL,
    fecha_vencimiento DATE,
    total NUMERIC(12, 2),
    estado VARCHAR(20) CHECK (estado IN ('pagada', 'pendiente')) NOT NULL
);

-- Crear tabla de detalles de facturas
CREATE TABLE factura_detalles (
    id SERIAL PRIMARY KEY,
    factura_id INT REFERENCES facturas(id) ON DELETE CASCADE,
    descripcion TEXT NOT NULL,
    cantidad INT NOT NULL,
    valor_unitario NUMERIC(12, 2) NOT NULL,
    subtotal NUMERIC(12, 2) NOT NULL
);

-- Crear tabla de pagos de clientes
CREATE TABLE pagos_clientes (
    id SERIAL PRIMARY KEY,
    empresa_id INT REFERENCES empresas(id) ON DELETE CASCADE,
    factura_id INT REFERENCES facturas(id) ON DELETE CASCADE,
    fecha_pago DATE NOT NULL,
    valor NUMERIC(12, 2) NOT NULL,
    metodo_pago VARCHAR(50)
);
