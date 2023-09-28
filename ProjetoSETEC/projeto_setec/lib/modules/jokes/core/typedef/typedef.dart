import 'package:dartz/dartz.dart';
import 'package:projeto_setec/modules/jokes/domain/entities/joke_entity.dart';
import 'package:projeto_setec/modules/jokes/domain/errors/errors.dart';

typedef CreateJokeResult = Either<JokeError, bool>;
typedef ReadJokesResult = Either<JokeError, List<JokeEntity>>;
typedef UpdateJokeResult = Either<JokeError, bool>;
typedef RemoveJokeResult = Either<JokeError, bool>;
//typedef GetJokesCategoryResultt = Either<JokeError, List<JokeCategoryEntity>>;