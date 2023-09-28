import 'package:projeto_setec/modules/jokes/core/typedef/typedef.dart';
import 'package:projeto_setec/modules/jokes/domain/entities/joke_entity.dart';

abstract class CreateJokeUsecase {
  Future<CreateJokeResult> call({
    required JokeEntity joke,
  });
}
