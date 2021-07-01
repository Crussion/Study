import discord, requests
from datetime import datetime, timedelta, timezone
from Data import *

class ERBS(discord.Client):
    global icon_link
    global icon_dict
    global bot_icon

    async def on_ready(self):
        print('Logged on as', self.user)
        self.bot_icon = "https://github.com/Crussion/Study/blob/main/Discord_bot/ERBS_Bot/ERBS_Bot/res/bser-logo-bot.png?raw=true"
        try:
            await self.get_channel(857109283790520352).send('```' + "봇이 켜졌습니다." + '```')
        except Exception as e:
            print(e)

    async def on_message(self, message):
        # don't respond to ourselves
        if message.author == self.user:
            return

        if message.content.lower().startswith('!nomal') | (message.content.split(' ')[0].lower() == '!n'):
            print('normal')
            await self.mk_send(message, 'n')

        if message.content.lower().startswith('!rank') | (message.content.split(' ')[0].lower() == '!r'):
            print('rank')
            await self.mk_send(message, 'r')

        if ((message.content.lower().split(' ')[0] == '!stat') | (message.content.split(' ')[0].lower() == '!s')):
            print('status')
            await self.mk_send(message, 's')

        if ((message.content.lower().split(' ')[0] == '!help') | (message.content.lower().split(' ')[0] == '!h')):
            embed=discord.Embed(title=" ", color=0x44ff00)
            embed.set_author(name="Commend List", icon_url=self.bot_icon)
            embed.add_field(name="!stat/!s NickName Season TeamMode", 
                            value="유저의 기본 정보를 나타냅니다.\
                                    \n(Detail - !stat/!s H/h)", inline=False)
            embed.add_field(name="!normal(rank)/!n(r) NickName TeamMode", 
                            value="최근 일반 게임 또는 최근 시즌 랭크 게임 최대 10개를 불러옵니다.\
                                    \n(Detail - !normal(rank)/!n(r) H/h", inline=False)

            await message.channel.send(embed=embed)

    async def mk_send(self, msg, mode = 'n'):
        #!stat
        if(mode == 's'):
            try:
                if(msg.content.split(' ')[1].lower() == 'h'):
                    await msg.channel.send('```!stat/!s NickName Season TeamMode\
                                                \nSeason : 0 = normal, 1 = season 1, 2 = Pre-season 2, 3 = season 2\
                                                \nTeamMode : solo, duo, trio / 1, 2, 3```')
                    return
                nickname = msg.content.split(' ')[1]
            except:
                await msg.channel.send('```닉네임을 입력해 주세요.```')
                return

            try:
                season = msg.content.split(' ')[2]
                if((season == '0') | (season == '1') | (season == '2') | (season == '3')):
                    pass
                else:
                    await msg.channel.send('```시즌을 입력해 주세요.\
                                                \n(0 = normal, 1 = season 1, 2 = Pre-2, 3 = season 2)```')
                    return
            except:
                await msg.channel.send('```시즌을 입력해 주세요.\
                                                \n(0 = normal, 1 = season 1, 2 = Pre-2, 3 = season 2)```')
                return
            try:
                teamMod = msg.content.split(' ')[3].lower()
                if((teamMod == 'solo') | (teamMod == '1')):
                    t_mode = '솔로'
                elif((teamMod == 'duo') | (teamMod == '2')):
                    t_mode = '듀오'
                elif((teamMod == 'trio') | (teamMod == '3')):
                    t_mode = '스쿼드'
                else:
                    await msg.channel.send('```모드를 입력해 주세요.\
                                                \n(solo, duo, trio / 1, 2, 3)```')
                    return
            except:
                await msg.channel.send('```모드를 입력해 주세요.\
                                            \n(solo, duo, trio / 1, 2, 3)```')
                return
        #!normal, !rank
        else:
            try:
                if(msg.content.split(' ')[1].lower() == 'h'):
                    await msg.channel.send('```!normal(rank)/!n(r) NickName TeamMode\
                                                \nTeamMode : solo, duo, trio / 1, 2, 3```')
                    return
                nickname = msg.content.split(' ')[1]
            except:
                await msg.channel.send('```닉네임을 입력해 주세요.```')
                return
            try:
                teamMod = msg.content.split(' ')[2].lower()
                if((teamMod == 'solo') | (teamMod == 'duo') | (teamMod == 'trio') | (teamMod == '1') | (teamMod == '2') | (teamMod == '3')):
                    pass
                else:
                    await msg.channel.send('```모드를 입력해 주세요.\
                                                \n(solo, duo, trio / 1, 2, 3)```')
                    return
            except:
                await msg.channel.send('```모드를 입력해 주세요.\
                                                \n(solo, duo, trio / 1, 2, 3)```')
                return
        wait_message = await msg.channel.send('```Wait a second...```')
        data = Data(nickname)
        print("code: ", data.code)
        if(data.code == 404):
            await wait_message.delete()
            await msg.channel.send('```존재하지 않는 닉네임입니다.```')
            return
        #!normal
        if(mode == 'n'): 
            await self.get_game_list(msg, 'normal', teamMod, data)
        #!rank
        elif(mode == 'r'): 
            await self.get_game_list(msg, 'rank', teamMod, data)
            await wait_message.delete()
        #!stat
        elif(mode == 's'):
            data.set_Season(season)
            stat_json = data.get_Stat(teamMod)
            if(stat_json == None):
                await wait_message.delete()
                await msg.channel.send("```전적이 존재하지 않습니다.```")
                return
            self.icon_link = data.icon_link

            embed=discord.Embed(title=nickname, url="https://dak.gg/bser/players/{0}?hl=ko-KR".format(nickname), description="{0} - most {1}".format(t_mode, data.icon_dict[data.char_num]), color=0x44ff00)
            embed.set_author(name="User Stat", icon_url=self.bot_icon)
            embed.set_thumbnail(url=self.icon_link)
            
            embed.add_field(name="MMR", value=str(stat_json['mmr']), inline=False)
            embed.add_field(name="게임 수", value=str(stat_json['totalGames']), inline=True)
            embed.add_field(name="승리 수", value=str(stat_json['totalWins']), inline=True)
            embed.add_field(name="승률", value=str(round(stat_json['totalWins'] / stat_json['totalGames'] * 100, 1)), inline=True)
            embed.add_field(name="평균 순위", value=str(stat_json['averageRank']), inline=True)
            embed.add_field(name="평균 킬", value=str(stat_json['averageKills']), inline=True)
            embed.add_field(name="평균 어시스트", value=str(stat_json['averageAssistants']), inline=True)
            embed.add_field(name="평균 동물 킬", value=str(stat_json['averageHunts']), inline=True)
            embed.set_footer(text="Detail - Click to Nickname", icon_url=self.bot_icon)

            await wait_message.delete()
            await msg.channel.send(embed=embed)
        else: 
            game_list = data.get_Game(msg, 'normal', teamMod, data)
            s = ''
            if(len(game_list) != 0):
                for n in game_list:
                    s = s + str(n) + '\n'
            else:
                s = '매치가 존재하지 않습니다.'
            await wait_message.delete()
            await msg.channel.send(s)

    async def get_game_list(self, msg, m_mode = 'normal', teamMod = '1', data = None):
        game_list = data.get_Game(m_mode, teamMod)
        stat_json = data.get_Stat(teamMod)
        if(m_mode == 'normal'): m = '일반'
        else: m = '랭크'
        embed=discord.Embed(title=" ", color=0x44ff00)
        embed.set_author(name="최근 {0} 10판".format(m), icon_url=self.bot_icon)
        for i in range(len(game_list)):
            lst = game_list[i]

            game_time = datetime.strptime(lst['startDtm'], '%Y-%m-%dT%H:%M:%S.%f%z')
            time_diff = datetime.now(timezone.utc) - game_time
            tm_d = int(time_diff.days)
            tm_h = int((time_diff.seconds / 3600) % 24)
            tm_m = int((time_diff.seconds / 60) % 60)
            tm_s = int(time_diff.seconds % 60)
            tm_str = ''
            if(tm_d != 0): tm_str = tm_str + '{0}일 '.format(tm_d)
            if(tm_h != 0): tm_str = tm_str + '{0}시간 '.format(tm_h)
            if(tm_m != 0): tm_str = tm_str + '{0}분 '.format(tm_m)
            if(tm_s != 0): tm_str = tm_str + '{0}초'.format(tm_s)
            tm_str = tm_str + '전에 플레이 함'
            
            if(i == 0):
                present_mmr = stat_json['mmr']
                rate_of_change = stat_json['mmr'] - lst['mmrBefore']
            else:
                present_mmr = game_list[i-1]['mmrBefore']
                rate_of_change = game_list[i-1]['mmrBefore'] - game_list[i]['mmrBefore']

            embed.add_field(name='{0:<2}.\t캐릭터 : {1:8}\n등 수 : {2:> 2}\t 킬 수 : {3:> 2}킬\t어시스트 : {4:> 2}\tMMR : {5: }   {6:+}'.format((i + 1), 
                                                                                                                       data.icon_dict[lst['characterNum']], 
                                                                                                                       lst['gameRank'], 
                                                                                                                       lst['playerKill'],
                                                                                                                       lst['playerAssistant'], 
                                                                                                                       present_mmr,
                                                                                                                       rate_of_change),
                            value=tm_str,inline = False)

        '''
        s = ''
        
        if(len(game_list) != 0):
            for n in game_list:
                s = s + str(n) + '\n'
        else:
            s = '매치가 존재하지 않습니다.'
        '''
        await msg.channel.send(embed=embed)

client = ERBS()
data = Data()

torken = data.Discord_torken
client.run(torken)
