import 'package:projeto_setec/modules/jokes/core/typedef/typedef.dart';
import 'package:projeto_setec/modules/jokes/domain/entities/joke_entity.dart';

abstract class UpdateJokeUsecase {
  Future<UpdateJokeResult> call({
    required JokeEntity joke,
  });
}
