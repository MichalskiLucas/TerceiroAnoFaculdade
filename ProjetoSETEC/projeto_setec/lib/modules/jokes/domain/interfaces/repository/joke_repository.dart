import 'package:projeto_setec/modules/jokes/core/typedef/typedef.dart';
import 'package:projeto_setec/modules/jokes/domain/entities/joke_entity.dart';

abstract class JokeRepository {
  Future<CreateJokeResult> createJock({
    required JokeEntity joke,
  });
  Future<ReadJokesResult> readJokes();
  Future<UpdateJokeResult> updateJoke({
    required JokeEntity joke,
  });
  Future<RemoveJokeResult> removeJoke({
    required String uid,
  });
  //Future<GetJokesCategoryResult> getJokeCategories();
}
