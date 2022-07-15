-- H2 2.1.212; 
;              
CREATE USER IF NOT EXISTS "USER" SALT 'c6838409d8eaa7a4' HASH '2ab554b4fb492fe399f263bd40849519d3e3fd0a25f48e30394e8faf452805bf' ADMIN;        
CREATE MEMORY TABLE "PUBLIC"."ADDON_IDENTIFIER"(
    "ADDON_UUID" BINARY(16) NOT NULL,
    "IDENTIFIER_UUID" BINARY(16) NOT NULL
);            
ALTER TABLE "PUBLIC"."ADDON_IDENTIFIER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ADDON_UUID", "IDENTIFIER_UUID");   
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.ADDON_IDENTIFIER;         
INSERT INTO "PUBLIC"."ADDON_IDENTIFIER" VALUES
(X'3989b8cf617c44458f8b3079262fe697', X'd0ad507bdb8244c8b66e77c5f4254a53'),
(X'3989b8cf617c44458f8b3079262fe697', X'69fc5c95cff242be8e7f7753b47d1d45'),
(X'69248026cb0c4f4fb37a78e16897705a', X'd0ad507bdb8244c8b66e77c5f4254a53'),
(X'69248026cb0c4f4fb37a78e16897705a', X'69fc5c95cff242be8e7f7753b47d1d45'); 
CREATE MEMORY TABLE "PUBLIC"."ADDON_TRANSLATION"(
    "ADDON_UUID" BINARY(16) NOT NULL,
    "TRANSLATION_UUID" BINARY(16) NOT NULL
);          
ALTER TABLE "PUBLIC"."ADDON_TRANSLATION" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("ADDON_UUID", "TRANSLATION_UUID"); 
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.ADDON_TRANSLATION;        
INSERT INTO "PUBLIC"."ADDON_TRANSLATION" VALUES
(X'3989b8cf617c44458f8b3079262fe697', X'1c67e54d33b84447a00275df772f715f'),
(X'3989b8cf617c44458f8b3079262fe697', X'e3176d938b7f40e98fd1e7a345367da9'),
(X'69248026cb0c4f4fb37a78e16897705a', X'1c67e54d33b84447a00275df772f715f'),
(X'69248026cb0c4f4fb37a78e16897705a', X'e3176d938b7f40e98fd1e7a345367da9');
CREATE MEMORY TABLE "PUBLIC"."FILTER_OPTION"(
    "UUID" BINARY(16) NOT NULL,
    "BRANDING" CHARACTER VARYING(255),
    "TYPE" INTEGER
);     
ALTER TABLE "PUBLIC"."FILTER_OPTION" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("UUID");               
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.FILTER_OPTION;            
INSERT INTO "PUBLIC"."FILTER_OPTION" VALUES
(X'd451641fd7f94a0aae7958901d162c1b', 'awkg', 1);  
CREATE MEMORY TABLE "PUBLIC"."FILTER_OPTION_ADDON"(
    "UUID" BINARY(16) NOT NULL,
    "ID" BINARY(16),
    "OPTION" BINARY(16)
);            
ALTER TABLE "PUBLIC"."FILTER_OPTION_ADDON" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7" PRIMARY KEY("UUID");         
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.FILTER_OPTION_ADDON;      
INSERT INTO "PUBLIC"."FILTER_OPTION_ADDON" VALUES
(X'3989b8cf617c44458f8b3079262fe697', X'00000000000000000000000000000001', X'd451641fd7f94a0aae7958901d162c1b'),
(X'69248026cb0c4f4fb37a78e16897705a', X'00000000000000000000000000000002', X'd451641fd7f94a0aae7958901d162c1b');            
CREATE MEMORY TABLE "PUBLIC"."FILTER_OPTION_ADDON_IDENTIFIER"(
    "UUID" BINARY(16) NOT NULL,
    "IDENTIFIER" CHARACTER VARYING(255)
);      
ALTER TABLE "PUBLIC"."FILTER_OPTION_ADDON_IDENTIFIER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1B" PRIMARY KEY("UUID");             
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.FILTER_OPTION_ADDON_IDENTIFIER;           
INSERT INTO "PUBLIC"."FILTER_OPTION_ADDON_IDENTIFIER" VALUES
(X'69fc5c95cff242be8e7f7753b47d1d45', 'three'),
(X'd0ad507bdb8244c8b66e77c5f4254a53', 'two');     
CREATE MEMORY TABLE "PUBLIC"."FILTER_OPTION_TRANSLATION"(
    "UUID" BINARY(16) NOT NULL,
    "LABEL" CHARACTER VARYING(255),
    "LANGUAGE" CHARACTER VARYING(255)
);         
ALTER TABLE "PUBLIC"."FILTER_OPTION_TRANSLATION" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E" PRIMARY KEY("UUID");   
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.FILTER_OPTION_TRANSLATION;
INSERT INTO "PUBLIC"."FILTER_OPTION_TRANSLATION" VALUES
(X'1c67e54d33b84447a00275df772f715f', U&'b\00fcro', 'de'),
(X'e3176d938b7f40e98fd1e7a345367da9', 'Office', 'en');      
CREATE MEMORY TABLE "PUBLIC"."OPTION_TRANSLATION"(
    "OPTION_UUID" BINARY(16) NOT NULL,
    "TRANSLATION_UUID" BINARY(16) NOT NULL
);        
ALTER TABLE "PUBLIC"."OPTION_TRANSLATION" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("OPTION_UUID", "TRANSLATION_UUID");               
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.OPTION_TRANSLATION;       
INSERT INTO "PUBLIC"."OPTION_TRANSLATION" VALUES
(X'd451641fd7f94a0aae7958901d162c1b', X'1c67e54d33b84447a00275df772f715f'),
(X'd451641fd7f94a0aae7958901d162c1b', X'e3176d938b7f40e98fd1e7a345367da9');       
ALTER TABLE "PUBLIC"."ADDON_IDENTIFIER" ADD CONSTRAINT "PUBLIC"."FKTGRXBRY4TI524AI8R6DS00BK5" FOREIGN KEY("ADDON_UUID") REFERENCES "PUBLIC"."FILTER_OPTION_ADDON"("UUID") NOCHECK;             
ALTER TABLE "PUBLIC"."FILTER_OPTION_ADDON" ADD CONSTRAINT "PUBLIC"."FKQV2EBBU9XIA79HBNANJRMVXYH" FOREIGN KEY("OPTION") REFERENCES "PUBLIC"."FILTER_OPTION"("UUID") NOCHECK;    
ALTER TABLE "PUBLIC"."ADDON_TRANSLATION" ADD CONSTRAINT "PUBLIC"."FKKKQSC5A2WIBWN0U0VRRO31C6Q" FOREIGN KEY("TRANSLATION_UUID") REFERENCES "PUBLIC"."FILTER_OPTION_TRANSLATION"("UUID") NOCHECK;
ALTER TABLE "PUBLIC"."ADDON_IDENTIFIER" ADD CONSTRAINT "PUBLIC"."FKQ4XGTIQBMRIBP6O4FSLITP7JG" FOREIGN KEY("IDENTIFIER_UUID") REFERENCES "PUBLIC"."FILTER_OPTION_ADDON_IDENTIFIER"("UUID") NOCHECK;             
ALTER TABLE "PUBLIC"."ADDON_TRANSLATION" ADD CONSTRAINT "PUBLIC"."FKNW5W6N88NMW39UGCUQNTV2LEL" FOREIGN KEY("ADDON_UUID") REFERENCES "PUBLIC"."FILTER_OPTION_ADDON"("UUID") NOCHECK;            
ALTER TABLE "PUBLIC"."OPTION_TRANSLATION" ADD CONSTRAINT "PUBLIC"."FKGRF9BFXBF1YF8W8QDOSQ0W0" FOREIGN KEY("OPTION_UUID") REFERENCES "PUBLIC"."FILTER_OPTION"("UUID") NOCHECK;  
ALTER TABLE "PUBLIC"."OPTION_TRANSLATION" ADD CONSTRAINT "PUBLIC"."FKCFAWTA7NH2D7D2TRTVXFGBKDK" FOREIGN KEY("TRANSLATION_UUID") REFERENCES "PUBLIC"."FILTER_OPTION_TRANSLATION"("UUID") NOCHECK;               
