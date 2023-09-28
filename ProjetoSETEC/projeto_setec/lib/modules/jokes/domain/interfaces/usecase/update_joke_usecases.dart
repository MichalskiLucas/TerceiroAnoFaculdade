import 'package:projeto_setec/modules/jokes/domain/entities/joke_entity.dart';

abstract class UpdateJokeUsecase {
  Future<UpdateJokeUsecase> call({
    required JokeEntity joke,
  });
}
