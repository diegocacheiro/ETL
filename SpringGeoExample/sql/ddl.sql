CREATE TABLE IF NOT EXISTS public.track_points
(
    track character varying(100) COLLATE pg_catalog."default" NOT NULL,
    point_id integer NOT NULL,
    point_geo geometry(Point,4326),
    speed double precision,
    elevation double precision,
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    measures json,
    CONSTRAINT track_points_pkey PRIMARY KEY (track, point_id)
)